package personal.ibonny.mo_remix.block.machines;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import personal.ibonny.mo_remix.MORemix;
import personal.ibonny.mo_remix.entities.BlockMicrowaveEntity;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class BlockMicrowave extends BaseEntityBlock {
    private static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
    private static final BooleanProperty RUNNING = BooleanProperty.create("running");

    private static final VoxelShape SHAPE_NORTH = // Negative Z
            Block.box(1, 0, 0, 15, 10, 11);
    private static final VoxelShape SHAPE_SOUTH = // Positive Z
            Block.box(1, 0, 5, 15, 10, 16);
    private static final VoxelShape SHAPE_EAST = // Positive X
            Block.box(5, 0, 1, 16, 10, 15);
    private static final VoxelShape SHAPE_WEST = // Negative X
            Block.box(0, 0, 1, 11, 10, 15);
    private static final Map<Direction, VoxelShape> ALL_SHAPES = new HashMap<>();

    public BlockMicrowave(Properties properties) {
        super(properties);

        ALL_SHAPES.put(Direction.NORTH, SHAPE_NORTH);
        ALL_SHAPES.put(Direction.SOUTH, SHAPE_SOUTH);
        ALL_SHAPES.put(Direction.EAST, SHAPE_EAST);
        ALL_SHAPES.put(Direction.WEST, SHAPE_WEST);

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(RUNNING, false)
        );
    }

    public static VoxelShape rotateShape(Direction from, Direction to, VoxelShape shape) {
        VoxelShape[] buffer = new VoxelShape[]{shape, Shapes.empty()};

        int times = (to.ordinal() - from.get2DDataValue() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = Shapes.or(buffer[1], Shapes.create(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = Shapes.empty();
        }

        return buffer[0];
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos,
                                        @NotNull CollisionContext pContext) {
        return ALL_SHAPES.get(pState.getValue(FACING).getOpposite());
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        BlockState blockState = super.getStateForPlacement(context);

        if (blockState == null) {
            return this.defaultBlockState();
        }

        return blockState.setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);

        builder.add(FACING);
        builder.add(RUNNING);
    }

    @Override
    @Deprecated
    public InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos,
                                 @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        level.setBlock(pos, state.cycle(RUNNING), 3);

        return InteractionResult.SUCCESS;
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new BlockMicrowaveEntity(blockPos, blockState);
    }
}

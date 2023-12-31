package personal.ibonny.mo_remix.block.machines;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import personal.ibonny.mo_remix.block.MOBaseBlock;
import personal.ibonny.mo_remix.entities.BlockMatterDecomposerEntity;

import javax.annotation.Nullable;

public class BlockMatterDecomposer extends MOBaseBlock {
    private static final BooleanProperty RUNNING = BooleanProperty.create("running");

    public BlockMatterDecomposer(Properties properties) {
        super(properties, BlockMatterDecomposerEntity::new);

        this.registerDefaultState(
            this.stateDefinition.any()
                .setValue(RUNNING, false)
        );
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

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);

        builder.add(RUNNING);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new BlockMatterDecomposerEntity(blockPos, blockState);
    }
}

package personal.ibonny.mo_remix.block.machines;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import personal.ibonny.mo_remix.block.MOBaseBlock;
import personal.ibonny.mo_remix.entities.BlockPatternStorageEntity;
import personal.ibonny.mo_remix.entities.ModBlockEntities;

import javax.annotation.Nullable;

public class BlockPatternStorage extends MOBaseBlock {
    public BlockPatternStorage(Properties properties) {
        super(properties, BlockPatternStorageEntity::new);
    }

    /* BLOCK ENTITY */

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof BlockPatternStorageEntity) {
                ((BlockPatternStorageEntity) blockEntity).drops();
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }

    @Override
    @Deprecated
    public InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos,
                                 @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
//        if (!level.isClientSide()) {
//            BlockEntity entity = level.getBlockEntity(pos);
//            if(entity instanceof BlockPatternStorageEntity) {
//                NetworkHooks.openScreen(((ServerPlayer) player), (BlockPatternStorageEntity) entity, pos);
//            } else {
//                throw new IllegalStateException("Our Container provider is missing!");
//            }
//        }
//
//        return InteractionResult.sidedSuccess(level.isClientSide());

        return super.use(state, level, pos, player, hand, hit);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.PATTERN_STORAGE.get(),
                BlockPatternStorageEntity::tick);
    }
}

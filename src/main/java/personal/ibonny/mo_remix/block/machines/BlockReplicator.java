package personal.ibonny.mo_remix.block.machines;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import personal.ibonny.mo_remix.block.MOBaseBlock;
import personal.ibonny.mo_remix.entities.BlockPatternStorageEntity;
import personal.ibonny.mo_remix.entities.BlockReplicatorEntity;

public class BlockReplicator extends MOBaseBlock {
    public BlockReplicator(Properties properties) {
        super(properties, BlockReplicatorEntity::new);
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
    public @NotNull RenderShape getRenderShape(@NotNull BlockState pState) {
        return RenderShape.MODEL;
    }
}

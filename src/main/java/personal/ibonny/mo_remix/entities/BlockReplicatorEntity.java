package personal.ibonny.mo_remix.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlockReplicatorEntity extends BlockEntity {
    public BlockReplicatorEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.REPLICATOR.get(), pPos, pBlockState);
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
//        nbt.put("inventory", itemHandler.serializeNBT());

        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);

//        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
    }
}

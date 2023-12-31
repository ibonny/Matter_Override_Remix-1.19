package personal.ibonny.mo_remix.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlockMicrowaveEntity extends BlockEntity {
//    protected final ContainerData data;
//
//    private int progress = 0;
//    private int maxProgress = 78;
//
//    private final ItemStackHandler itemHandler = new ItemStackHandler(3) {
//        @Override
//        protected void onContentsChanged(int slot) {
//            setChanged();
//        }
//    };
//
//    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public BlockMicrowaveEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.MICROWAVE.get(), pos, blockState);

//        this.data = new ContainerData() {
//            @Override
//            public int get(int index) {
//                return switch(index) {
//                    case 0 -> BlockMicrowaveEntity.this.progress;
//                    case 1 -> BlockMicrowaveEntity.this.maxProgress;
//                    default -> 0;
//                };
//            }
//
//            @Override
//            public void set(int index, int value) {
//                switch(index) {
//                    case 0 -> BlockMicrowaveEntity.this.progress = value;
//                    case 1 -> BlockMicrowaveEntity.this.maxProgress = value;
//                };
//            }
//
//            @Override
//            public int getCount() {
//                return 2;
//            }
//        };
    }

//    @Override
//    public @NotNull Component getDisplayName() {
//        return Component.literal("Microwave");
//    }

//    @Nullable
//    @Override
//    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
//        return new MatterAnalyzerMenu(id, inventory, this, this.data);
//    }

//    @Override
//    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
//        if (cap == ForgeCapabilities.ITEM_HANDLER) {
//            return lazyItemHandler.cast();
//        }
//
//        return super.getCapability(cap, side);
//    }
//
//    @Override
//    public void onLoad() {
//        super.onLoad();
//
//        lazyItemHandler = LazyOptional.of(() -> itemHandler);
//    }
//
//    @Override
//    public void invalidateCaps() {
//        super.invalidateCaps();
//
//        lazyItemHandler.invalidate();
//    }
//
//    @Override
//    protected void saveAdditional(CompoundTag nbt) {
//        nbt.put("inventory", itemHandler.serializeNBT());
//
//        super.saveAdditional(nbt);
//    }
//
//    @Override
//    public void load(CompoundTag nbt) {
//        super.load(nbt);
//
//        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
//    }
//
//    public void drops() {
//        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
//
//        for (int i=0; i < itemHandler.getSlots(); i++) {
//            inventory.setItem(i, itemHandler.getStackInSlot(i));
//        }
//
//        if (this.level != null) {
//            Containers.dropContents(this.level, this.worldPosition, inventory);
//        }
//    }
//
//    public static void tick(Level level, BlockPos pos, BlockState state, BlockMicrowaveEntity entity) {
//        if (level.isClientSide()) {
//            return;
//        }
//
//        if (hasRecipe(entity)) {
//            entity.progress++;
//            setChanged(level, pos, state);
//
//            if (entity.progress >= entity.maxProgress) {
//                craftItem(entity);
//            }
//        } else {
//            entity.resetProgress();
//            setChanged(level, pos, state);
//
//        }
//    }
//
//    private void resetProgress() {
//        this.progress = 0;
//    }
//
//    private static void craftItem(BlockMicrowaveEntity entity) {
//        if (hasRecipe(entity)) {
//            entity.itemHandler.extractItem(1, 1, false);
//            entity.itemHandler.setStackInSlot(2, new ItemStack(Items.DIAMOND,
//                    entity.itemHandler.getStackInSlot(2).getCount() + 1));
//
//            entity.resetProgress();
//        }
//    }
//
//    private static boolean hasRecipe(BlockMicrowaveEntity entity) {
//        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
//
//        for (int i=0; i < entity.itemHandler.getSlots(); i++) {
//            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
//        }
//
//        boolean hasItemInFirstSlot = entity.itemHandler.getStackInSlot(1).getItem() == ModItems.DATAPAD.get();
//
//        return hasItemInFirstSlot && canInsertItemsIntoOutputSlot(inventory) &&
//                canInsertItemIntoOutputSlot(inventory, new ItemStack(ModItems.DATAPAD.get(), 1));
//    }
//
//    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack itemStack) {
//        return inventory.getItem(2).getItem() == itemStack.getItem() ||
//                inventory.getItem(2).isEmpty();
//    }
//
//    private static boolean canInsertItemsIntoOutputSlot(SimpleContainer inventory) {
//        return inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
//    }
}

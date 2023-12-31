//package personal.ibonny.mo_remix.datagen;
//
//import net.minecraft.data.PackOutput;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.RotatedPillarBlock;
//import net.minecraftforge.client.model.generators.BlockStateProvider;
//import net.minecraftforge.common.data.ExistingFileHelper;
//import net.minecraftforge.registries.RegistryObject;
//import personal.ibonny.mo_remix.MORemix;
//import personal.ibonny.mo_remix.block.ModBlocks;
//
//public class ModBlockStateProvider extends BlockStateProvider {
//    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
//        super(output, MORemix.MOD_ID, exFileHelper);
//    }
//
//    @Override
//    protected void registerStatesAndModels() {
//        axisBlockWithItem(ModBlocks.TRITANIUM_PLATE_STRIPES, "block/base_stripes", "block/base");
//        blockWithItem(ModBlocks.TRITANIUM_PLATE);
//    }
//
//    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
//        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
//    }
//
//    private void axisBlockWithItem(RegistryObject<Block> blockRegistryObject, String sides, String topAndBottom) {
//        ResourceLocation side = new ResourceLocation(MORemix.MOD_ID, sides);
//        ResourceLocation topBottom = new ResourceLocation(MORemix.MOD_ID, topAndBottom);
//
//        axisBlock((RotatedPillarBlock) blockRegistryObject.get(), side, topBottom);
//    }
//}

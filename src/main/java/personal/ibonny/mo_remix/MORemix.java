package personal.ibonny.mo_remix;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import personal.ibonny.mo_remix.block.ModBlocks;
import personal.ibonny.mo_remix.entities.ModBlockEntities;
import personal.ibonny.mo_remix.item.ModCreativeModeTabs;
import personal.ibonny.mo_remix.item.ModItems;
import personal.ibonny.mo_remix.screen.MatterAnalyzerScreen;
import personal.ibonny.mo_remix.screen.ModMenuTypes;

import java.util.ArrayList;
import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MORemix.MOD_ID)
public class MORemix {
    public static final String MOD_ID = "mo_remix";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MORemix() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModCreativeModeTabs.MO_REMIX_TAB) {
            /* Items. */
            event.accept(ModItems.DATAPAD);

            /* Machines. */
            event.accept(ModBlocks.MATTER_ANALYZER);
            event.accept(ModBlocks.PATTERN_STORAGE);
            event.accept(ModBlocks.MICROWAVE);
            event.accept(ModBlocks.REPLICATOR);
            event.accept(ModBlocks.MATTER_DECOMPOSER);

            /* Ores. */
            event.accept(ModBlocks.TRITANIUM_ORE);

            /* Decorative. */
            event.accept(ModBlocks.TRITANIUM_PLATE_STRIPES);
            event.accept(ModBlocks.TRITANIUM_PLATE);
            event.accept(ModBlocks.BEAMS);
            event.accept(ModBlocks.VENT_BRIGHT);
            event.accept(ModBlocks.FLOOR_TILES);
            event.accept(ModBlocks.CARBON_FIBER_PLATE);
            event.accept(ModBlocks.CLEAN);
            event.accept(ModBlocks.COILS);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(ModMenuTypes.MATTER_ANALYZER_MENU.get(), MatterAnalyzerScreen::new);

//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.REPLICATOR.get(), RenderType.cutout());
        }
    }
}

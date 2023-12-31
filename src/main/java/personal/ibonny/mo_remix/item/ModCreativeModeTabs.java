package personal.ibonny.mo_remix.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import personal.ibonny.mo_remix.MORemix;

@Mod.EventBusSubscriber(modid = MORemix.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab MO_REMIX_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        MO_REMIX_TAB = event.registerCreativeModeTab(new ResourceLocation(MORemix.MOD_ID, "mo_remix_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.DATAPAD.get())).title(Component.translatable("creativemodetab.mo_remix_tab")));
    }
}

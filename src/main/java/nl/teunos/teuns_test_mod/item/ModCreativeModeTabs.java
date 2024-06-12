package nl.teunos.teuns_test_mod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import nl.teunos.teuns_test_mod.teuns_test_mod;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, teuns_test_mod.MODID);

    public static final RegistryObject<CreativeModeTab> TEUN_TEST_TAB = CREATIVE_MODE_TABS.register("teun_test_tab",
        () -> CreativeModeTab.builder()
        .icon(() -> ModTestItems.POEPIE.get().getDefaultInstance())
        .title(Component.translatable("creativetab." + teuns_test_mod.MODID + ".teun_test_tab"))
        .displayItems((parameters, output) -> {
            // ITEMS GO HERE
            output.accept(ModTestItems.POEPIE.get());
        })
        .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

package nl.teunos.teuns_test_mod.objects;
import nl.teunos.teuns_test_mod.teuns_test_mod;
import nl.teunos.teuns_test_mod.objects.customTest.CustomPoepItem;
import nl.teunos.teuns_test_mod.objects.customTest.TestItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class ModTestItems {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, teuns_test_mod.MODID);

    private static final FoodProperties POEPFOOD = new FoodProperties.Builder()
        .alwaysEdible()
        .effect(new MobEffectInstance(MobEffects.POISON, 600, 1), 1.0f)
        .effect(new MobEffectInstance(MobEffects.HUNGER, 600, 1), 1.0f)
        .effect(new MobEffectInstance(MobEffects.CONFUSION, 600, 1), 1.0f)
        .nutrition(-13).saturationModifier(0.1f)
        .build();

    // public static final RegistryObject<Item> POEPIE = ITEMS.register("poepie",
    //     () -> new Item(new Item.Properties().food(POEPFOOD)));

    public static final RegistryObject<Item> POEPIE = ITEMS.register("poepie",
        () -> new CustomPoepItem(new Item.Properties().durability(100).food(POEPFOOD)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

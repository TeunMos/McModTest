package nl.teunos.teuns_test_mod.objects;

import com.google.common.base.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nl.teunos.teuns_test_mod.objects.customTest.TestBlock;
import nl.teunos.teuns_test_mod.teuns_test_mod;

public class ModTestBlocks {
    public static final DeferredRegister<Block> BLOCKS = 
        DeferredRegister.create(ForgeRegistries.BLOCKS, teuns_test_mod.MODID);


    
    public static final RegistryObject<Block> POEPIE_BLOCK = registerBlock("poepie_block", 
        () -> new TestBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SLIME_BLOCK))
    );
    

    // Function for registering blocks and their corresponding block items
    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> registryObject = BLOCKS.register(name, block);
        registerBlockItem(name, registryObject);
        return registryObject;
    }
    private static <T extends Block> RegistryObject<BlockItem> registerBlockItem(String name, RegistryObject<T> block) {
        return ModTestItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }   


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
    
}

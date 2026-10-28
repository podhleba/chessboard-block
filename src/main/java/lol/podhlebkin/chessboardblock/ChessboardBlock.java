package lol.podhlebkin.chessboardblock;

import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.minecraft.world.item.CreativeModeTabs;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(ChessboardBlock.MOD_ID)
public class ChessboardBlock {
    //Mod id
    public static final String MOD_ID = "chessboard_block";
    //Idk what ts is
    public static final Logger LOGGER = LogUtils.getLogger();



    public ChessboardBlock(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        Items.register(modEventBus);
        Blocks.register(modEventBus);
        CreativeTab.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }


    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}

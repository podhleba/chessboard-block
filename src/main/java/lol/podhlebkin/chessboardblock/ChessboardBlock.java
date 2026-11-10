package lol.podhlebkin.chessboardblock;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChessboardBlock implements ModInitializer {

	public static final String MOD_ID = "chessboard_block";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		Items.register();
		Blocks.register();
		CreativeTab.register();
	}
}

package river.rollforinitiative.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import river.rollforinitiative.common.block.EncounterManagerBlock;
import river.rollforinitiative.common.blockentity.EncounterManagerBlockEntity;
import river.rollforinitiative.common.stat.CharacterStats;
import river.rollforinitiative.network.messages.OpenCharacterSheetMessage;
import river.rollforinitiative.network.messages.OpenEncounterManagerMessage;

import java.util.UUID;

public class CharacterSheetItem extends Item {
    public CharacterSheetItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {

        if (interactionHand == InteractionHand.MAIN_HAND) {

            if (level instanceof ServerLevel && player instanceof ServerPlayer serverPlayer) {
                ItemStack stack = player.getItemInHand(interactionHand);
                String name = stack.getDisplayName().getString().replace("[", "").replace("]", "");
                new OpenCharacterSheetMessage(new CharacterStats(UUID.randomUUID().toString(), name, 60, 45, 12, 5)).send(serverPlayer); // TODO: Have these character stats saved on the server, and have the character sheet reference an ID instead.
            }
        }



        return super.use(level, player, interactionHand);
    }


    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {

        BlockPos clickedPos = useOnContext.getClickedPos();

        if (useOnContext.getLevel().getBlockEntity(clickedPos) instanceof EncounterManagerBlockEntity blockEntity) {
            ItemStack stack = useOnContext.getItemInHand();
            useOnContext.getLevel().playSound(useOnContext.getPlayer(), clickedPos, SoundEvents.STONE_BUTTON_CLICK_ON, SoundSource.BLOCKS, 1f, 1f);

            String name = stack.getDisplayName().getString().replace("[", "").replace("]", "");
            CharacterStats characterStats = new CharacterStats(UUID.randomUUID().toString(),name, 60, 45, 12, 5);
            blockEntity.addCharacterSheet(useOnContext.getPlayer(), characterStats);
        }

        return super.useOn(useOnContext);
    }
}

package river.rollforinitiative.common.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import river.rollforinitiative.common.item.CharacterSheetItem;
import river.rollforinitiative.common.item.GameMasterScreenItem;
import river.rollforinitiative.common.stat.CharacterStats;
import river.rollforinitiative.network.messages.OpenEncounterManagerMessage;
import river.rollforinitiative.registry.RFIBlockEntities;
import river.rollforinitiative.util.PlayerUtil;

import java.util.ArrayList;
import java.util.List;

public class EncounterManagerBlockEntity extends BlockEntity {

    private List<CharacterStats> charactersInInitiative = new ArrayList<>();

    public EncounterManagerBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(RFIBlockEntities.ENCOUNTER_MANAGER.get(), blockPos, blockState);
    }

    public void onInteracted(Level level, Player player, ItemStack itemStack, boolean remote) {
        System.out.println("Interacted");

        if (getLevel() instanceof ServerLevel serverLevel && player instanceof ServerPlayer serverPlayer) {

            if (itemStack.getItem() == Items.BLAZE_ROD) {
                System.out.println("The " + charactersInInitiative.size() + " characters in the initiative are: ");
                for (CharacterStats characterStat : charactersInInitiative) {
                    System.out.println(characterStat.getName());
                }
            }

            if (!((itemStack.getItem() instanceof CharacterSheetItem || itemStack.getItem() instanceof GameMasterScreenItem)) || remote) {
                new OpenEncounterManagerMessage().send(serverPlayer);
            } else {

                if (itemStack.getItem() instanceof CharacterSheetItem) {
                    System.out.println(itemStack.getDisplayName().getString());
                }
            }
        }
    }

    public void addCharacterSheet(Player player, CharacterStats characterStat) {
        charactersInInitiative.add(characterStat);
        PlayerUtil.sendMessage(player, Component.translatable("Added: ").append(characterStat.getName()), true);
        System.out.println("Added: " + characterStat.getName());
    }
}

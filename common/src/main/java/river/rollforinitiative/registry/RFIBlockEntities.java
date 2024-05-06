package river.rollforinitiative.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import river.rollforinitiative.RollForInitiative;
import river.rollforinitiative.common.blockentity.EncounterManagerBlockEntity;

public class RFIBlockEntities {

    public static final DeferredRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegistry.create(RollForInitiative.MODID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<EncounterManagerBlockEntity>> ENCOUNTER_MANAGER = BLOCK_ENTITY_TYPES.register("encounter_manager", () -> BlockEntityType.Builder.of(EncounterManagerBlockEntity::new, RFIBlocks.ENCOUNTER_MANAGER.get()).build(null));

}

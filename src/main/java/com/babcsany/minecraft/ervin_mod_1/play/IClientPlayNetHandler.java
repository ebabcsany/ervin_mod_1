package com.babcsany.minecraft.ervin_mod_1.play;

import com.babcsany.minecraft.ervin_mod_1.play.server.SUpdateBossInfoPacket;
import net.minecraft.network.INetHandler;
import net.minecraft.network.play.server.*;

public interface IClientPlayNetHandler extends net.minecraft.client.network.play.IClientPlayNetHandler {
   /**
    * Spawns an instance of the objecttype indicated by the packet and sets its position and momentum
    */
   void handleSpawnObject(SSpawnObjectPacket packetIn);

   /**
    * Spawns an experience orb and sets its value (amount of XP)
    */
   void handleSpawnExperienceOrb(SSpawnExperienceOrbPacket packetIn);

   /**
    * Spawns the mob entity at the specified location, with the specified rotation, momentum and type. Updates the
    * entities Datawatchers with the entity metadata specified in the packet
    */
   void handleSpawnMob(SSpawnMobPacket packetIn);

   /**
    * May create a scoreboard objective, remove an objective from the scoreboard or update an objectives' displayname
    */
   void handleScoreboardObjective(SScoreboardObjectivePacket packetIn);

   /**
    * Handles the spawning of a painting object
    */
   void handleSpawnPainting(SSpawnPaintingPacket packetIn);

   /**
    * Handles the creation of a nearby player entity, sets the position and held item
    */
   void handleSpawnPlayer(SSpawnPlayerPacket packetIn);

   /**
    * Renders a specified animation: Waking up a player, a living entity swinging its currently held item, being hurt or
    * receiving a critical hit by normal or magical means
    */
   void handleAnimation(SAnimateHandPacket packetIn);

   /**
    * Updates the players statistics or achievements
    */
   void handleStatistics(SStatisticsPacket packetIn);

   void handleRecipeBook(SRecipeBookPacket packetIn);

   /**
    * Updates all registered IWorldAccess instances with destroyBlockInWorldPartially
    */
   void handleBlockBreakAnim(SAnimateBlockBreakPacket packetIn);

   /**
    * Creates a sign in the specified location if it didn't exist and opens the GUI to edit its text
    */
   void handleSignEditorOpen(SOpenSignMenuPacket packetIn);

   /**
    * Updates the NBTTagCompound metadata of instances of the following entitytypes: Mob spawners, command blocks,
    * beacons, skulls, flowerpot
    */
   void handleUpdateTileEntity(SUpdateTileEntityPacket packetIn);

   /**
    * Triggers Block.onBlockEventReceived, which is implemented in BlockPistonBase for extension/retraction, BlockNote
    * for setting the instrument (including audiovisual feedback) and in BlockContainer to set the number of players
    * accessing a (Ender)Chest
    */
   void handleBlockAction(SBlockActionPacket packetIn);

   /**
    * Updates the block and metadata and generates a blockupdate (and notify the clients)
    */
   void handleBlockChange(SChangeBlockPacket packetIn);

   /**
    * Prints a chatmessage in the chat GUI
    */
   void handleChat(SChatPacket packetIn);

   /**
    * Received from the servers PlayerManager if between 1 and 64 blocks in a chunk are changed. If only one block
    * requires an update, the server sends S23PacketBlockChange and if 64 or more blocks are changed, the server sends
    * S21PacketChunkData
    */
   void handleMultiBlockChange(SMultiBlockChangePacket packetIn);

   /**
    * Updates the worlds MapStorage with the specified MapData for the specified map-identifier and invokes a
    * MapItemRenderer for it
    */
   void handleMaps(SMapDataPacket packetIn);

   /**
    * Verifies that the server and client are synchronized with respect to the inventory/container opened by the player
    * and confirms if it is the case.
    */
   void handleConfirmTransaction(SConfirmTransactionPacket packetIn);

   /**
    * Resets the ItemStack held in hand and closes the window that is opened
    */
   void handleCloseWindow(SCloseWindowPacket packetIn);

   /**
    * Handles the placement of a specified ItemStack in a specified container/inventory slot
    */
   void handleWindowItems(SWindowItemsPacket packetIn);

   void handleOpenHorseWindow(SOpenHorseWindowPacket packetIn);

   /**
    * Sets the progressbar of the opened window to the specified value
    */
   void handleWindowProperty(SWindowPropertyPacket packetIn);

   /**
    * Handles pickin up an ItemStack or dropping one in your inventory or an open (non-creative) container
    */
   void handleSetSlot(SSetSlotPacket packetIn);

   /**
    * Handles packets that have room for a channel specification. Vanilla implemented channels are "MC|TrList" to
    * acquire a MerchantRecipeList trades for a villager merchant, "MC|Brand" which sets the server brand? on the player
    * instance and finally "MC|RPack" which the server uses to communicate the identifier of the default server
    * resourcepack for the client to load.
    */
   void handleCustomPayload(SCustomPayloadPlayPacket packetIn);

   /**
    * Closes the network channel
    */
   void handleDisconnect(SDisconnectPacket packetIn);

   /**
    * Invokes the entities' handleUpdateHealth method which is implemented in LivingBase (hurt/death),
    * MinecartMobSpawner (spawn delay), FireworkRocket & MinecartTNT (explosion), IronGolem (throwing,...), Witch (spawn
    * particles), Zombie (villager transformation), Animal (breeding mode particles), Horse (breeding/smoke particles),
    * Sheep (...), Tameable (...), Villager (particles for breeding mode, angry and happy), Wolf (...)
    */
   void handleEntityStatus(SEntityStatusPacket packetIn);

   void handleEntityAttach(SMountEntityPacket packetIn);

   void handleSetPassengers(SSetPassengersPacket packetIn);

   /**
    * Initiates a new explosion (sound, particles, drop spawn) for the affected blocks indicated by the packet.
    */
   void handleExplosion(SExplosionPacket packetIn);

   void handleChangeGameState(SChangeGameStatePacket packetIn);

   void handleKeepAlive(SKeepAlivePacket packetIn);

   /**
    * Updates the specified chunk with the supplied data, marks it for re-rendering and lighting recalculation
    */
   void handleChunkData(SChunkDataPacket packetIn);

   void processChunkUnload(SUnloadChunkPacket packetIn);

   void handleEffect(SPlaySoundEventPacket packetIn);

   /**
    * Registers some server properties (gametype,hardcore-mode,terraintype,difficulty,player limit), creates a new
    * WorldClient and sets the player initial dimension
    */
   void handleJoinGame(SJoinGamePacket packetIn);

   /**
    * Updates the specified entity's position by the specified relative moment and absolute rotation. Note that
    * subclassing of the packet allows for the specification of a subset of this data (e.g. only rel. position, abs.
    * rotation or both).
    */
   void handleEntityMovement(SEntityPacket packetIn);

   void handlePlayerPosLook(SPlayerPositionLookPacket packetIn);

   /**
    * Spawns a specified number of particles at the specified location with a randomized displacement according to
    * specified bounds
    */
   void handleParticles(SSpawnParticlePacket packetIn);

   void handlePlayerAbilities(SPlayerAbilitiesPacket packetIn);

   void handlePlayerListItem(SPlayerListItemPacket packetIn);

   /**
    * Locally eliminates the entities. Invoked by the server when the items are in fact destroyed, or the player is no
    * longer registered as required to monitor them. The latter  happens when distance between the player and item
    * increases beyond a certain treshold (typically the viewing distance)
    */
   void handleDestroyEntities(SDestroyEntitiesPacket packetIn);

   void handleRemoveEntityEffect(SRemoveEntityEffectPacket packetIn);

   void handleRespawn(SRespawnPacket packetIn);

   /**
    * Updates the direction in which the specified entity is looking, normally this head rotation is independent of the
    * rotation of the entity itself
    */
   void handleEntityHeadLook(SEntityHeadLookPacket packetIn);

   /**
    * Updates which hotbar slot of the player is currently selected
    */
   void handleHeldItemChange(SHeldItemChangePacket packetIn);

   /**
    * Removes or sets the ScoreObjective to be displayed at a particular scoreboard position (list, sidebar, below name)
    */
   void handleDisplayObjective(SDisplayObjectivePacket packetIn);

   /**
    * Invoked when the server registers new proximate objects in your watchlist or when objects in your watchlist have
    * changed -> Registers any changes locally
    */
   void handleEntityMetadata(SEntityMetadataPacket packetIn);

   /**
    * Sets the velocity of the specified entity to the specified value
    */
   void handleEntityVelocity(SEntityVelocityPacket packetIn);

   void handleEntityEquipment(SEntityEquipmentPacket packetIn);

   void handleSetExperience(SSetExperiencePacket packetIn);

   void handleUpdateHealth(SUpdateHealthPacket packetIn);

   /**
    * Updates a team managed by the scoreboard: Create/Remove the team registration, Register/Remove the player-team-
    * memberships, Set team displayname/prefix/suffix and/or whether friendly fire is enabled
    */
   void handleTeams(STeamsPacket packetIn);

   /**
    * Either updates the score with a specified value or removes the score for an objective
    */
   void handleUpdateScore(SUpdateScorePacket packetIn);

   void func_230488_a_(SWorldSpawnChangedPacket p_230488_1_);

   void handleTimeUpdate(SUpdateTimePacket packetIn);

   void handleSoundEffect(SPlaySoundEffectPacket packetIn);

   void handleSpawnMovingSoundEffect(SSpawnMovingSoundEffectPacket packetIn);

   void handleCustomSound(SPlaySoundPacket packetIn);

   void handleCollectItem(SCollectItemPacket packetIn);

   /**
    * Updates an entity's position and rotation as specified by the packet
    */
   void handleEntityTeleport(SEntityTeleportPacket packetIn);

   /**
    * Updates en entity's attributes and their respective modifiers, which are used for speed bonusses (player
    * sprinting, animals fleeing, baby speed), weapon/tool attackDamage, hostiles followRange randomization, zombie
    * maxHealth and knockback resistance as well as reinforcement spawning chance.
    */
   void handleEntityProperties(SEntityPropertiesPacket packetIn);

   void handleEntityEffect(SPlayEntityEffectPacket packetIn);

   void handleTags(STagsListPacket packetIn);

   void handleCombatEvent(SCombatPacket packetIn);

   void handleServerDifficulty(SServerDifficultyPacket packetIn);

   void handleCamera(SCameraPacket packetIn);

   void handleWorldBorder(SWorldBorderPacket packetIn);

   void handleTitle(STitlePacket packetIn);

   void handlePlayerListHeaderFooter(SPlayerListHeaderFooterPacket packetIn);

   void handleResourcePack(SSendResourcePackPacket packetIn);

   void handleUpdateBossInfo(SUpdateBossInfoPacket packetIn);

   void handleCooldown(SCooldownPacket packetIn);

   void handleMoveVehicle(SMoveVehiclePacket packetIn);

   void handleAdvancementInfo(SAdvancementInfoPacket packetIn);

   void handleSelectAdvancementsTab(SSelectAdvancementsTabPacket packetIn);

   void handlePlaceGhostRecipe(SPlaceGhostRecipePacket packetIn);

   void handleCommandList(SCommandListPacket packetIn);

   void handleStopSound(SStopSoundPacket packetIn);

   /**
    * This method is only called for manual tab-completion (the {@link
    * net.minecraft.command.arguments.SuggestionProviders#ASK_SERVER minecraft:ask_server} suggestion provider).
    */
   void handleTabComplete(STabCompletePacket packetIn);

   void handleUpdateRecipes(SUpdateRecipesPacket packetIn);

   void handlePlayerLook(SPlayerLookPacket packetIn);

   void handleNBTQueryResponse(SQueryNBTResponsePacket packetIn);

   void handleUpdateLight(SUpdateLightPacket packetIn);

   void handleOpenBookPacket(SOpenBookWindowPacket packetIn);

   void handleOpenWindowPacket(SOpenWindowPacket packetIn);

   void handleMerchantOffers(SMerchantOffersPacket packetIn);

   void handleUpdateViewDistancePacket(SUpdateViewDistancePacket packetIn);

   void handleChunkPositionPacket(SUpdateChunkPositionPacket packetIn);

   void handleAcknowledgePlayerDigging(SPlayerDiggingPacket packetIn);
}

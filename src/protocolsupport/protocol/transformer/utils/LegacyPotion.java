package protocolsupport.protocol.transformer.utils;

import com.google.common.collect.HashBiMap;

//TODO: throwable
public class LegacyPotion {

	private static final HashBiMap<String, Integer> potionToLegacyIds = HashBiMap.create();
	static {
		potionToLegacyIds.put("minecraft:night_vision", 8198);
		potionToLegacyIds.put("minecraft:long_night_vision", 8262);
        potionToLegacyIds.put("minecraft:invisibility", 8206);
        potionToLegacyIds.put("minecraft:long_invisibility", 8270);
        potionToLegacyIds.put("minecraft:leaping", 8203);
        potionToLegacyIds.put("minecraft:long_leaping", 8267);
        potionToLegacyIds.put("minecraft:strong_leaping", 8235);
        potionToLegacyIds.put("minecraft:fire_resistance", 8195);
        potionToLegacyIds.put("minecraft:long_fire_resistance", 8259);
        potionToLegacyIds.put("minecraft:swiftness", 8194);
        potionToLegacyIds.put("minecraft:long_swiftness", 8258);
        potionToLegacyIds.put("minecraft:strong_swiftness", 8226);
        potionToLegacyIds.put("minecraft:slowness", 8202);
        potionToLegacyIds.put("minecraft:long_slowness", 8266);
        potionToLegacyIds.put("minecraft:water_breathing", 8205);
        potionToLegacyIds.put("minecraft:long_water_breathing", 8269);
        potionToLegacyIds.put("minecraft:healing", 8197);
        potionToLegacyIds.put("minecraft:strong_healing", 8229);
        potionToLegacyIds.put("minecraft:harming", 8204);
        potionToLegacyIds.put("minecraft:strong_harming", 8236);
        potionToLegacyIds.put("minecraft:poison", 8196);
        potionToLegacyIds.put("minecraft:long_poison", 8260);
        potionToLegacyIds.put("minecraft:strong_poison", 8228);
        potionToLegacyIds.put("minecraft:regeneration", 8193);
        potionToLegacyIds.put("minecraft:long_regeneration", 8257);
        potionToLegacyIds.put("minecraft:strong_regeneration", 8225);
        potionToLegacyIds.put("minecraft:strength", 8201);
        potionToLegacyIds.put("minecraft:long_strength", 8265);
        potionToLegacyIds.put("minecraft:strong_strength", 8233);
        potionToLegacyIds.put("minecraft:weakness", 8200);
        potionToLegacyIds.put("minecraft:long_weakness", 8264);
	}

	public static Integer toLegacyId(String nbttag, boolean isThrowable) {
		Integer value = potionToLegacyIds.get(nbttag);
		if (value != null && isThrowable) {
			value += 8192;
		}
		return value;
	}

	public static String toNBTTag(int legacyId, boolean isThrowable) {
		if (isThrowable) {
			legacyId -= 8192;
		}
		return potionToLegacyIds.inverse().get(legacyId);
	}

}

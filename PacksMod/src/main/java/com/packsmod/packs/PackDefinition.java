package com.packsmod.packs;

public record PackDefinition(String key, String displayName, String folderName, PackCategory category) {
	public boolean isResourcePack() {
		return category == PackCategory.RESOURCE || category == PackCategory.FONT || category == PackCategory.ARMOR;
	}

	public boolean isShaderPack() {
		return category == PackCategory.SHADER;
	}
}

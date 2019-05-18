public enum ToppingType{
    TOMMATO("tomatoo"), MASHROOM("mashroom"), CHICKEN("chicken");

    private final String value;

	private ToppingType(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}
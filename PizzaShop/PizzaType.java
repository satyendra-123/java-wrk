public enum PizzaType{
    VEG_PIZZA("vegpizza"), NONVEG_PIZZA("nonvegpizza");

    private final String value;

	private PizzaType(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}
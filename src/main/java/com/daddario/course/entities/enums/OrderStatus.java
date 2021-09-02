package com.daddario.course.entities.enums;

public enum OrderStatus {

	/* Jeito mais simples é apenas declarar sem colocar numero
	 * Mas neste caso ele cria automaticamente os numeros, se eu colocar outro depois dá problema.
	 */
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELLED(5);
	
	/*
	 * Quando eu coloco o numero como acima, é necessário criar construtor e Métodos
	 */
	private int code;
	
	/*
	 * Notar que apenas no Enum é private
	 */
	private OrderStatus(int code)
	{
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	/* Lembrar que é static para eu não ter que instacinar o objeto */
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	
}

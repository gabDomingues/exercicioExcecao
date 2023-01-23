package model.entities;

import model.exceptions.DomainException;

public class Conta {
	private Integer numero;
	private String dono;
	private Double saldo;
	private double limiteSaque;
	
	public Conta() {
	}

	public Conta(Integer numero, String dono, Double saldo, double limiteSaque) {
		this.numero = numero;
		this.dono = dono;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public Double getSaldo() {
		return saldo;
	}

	public double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}
	
	public void deposito(double valor) {
		this.saldo += valor;
	}
	
	public void saque(double valor) throws DomainException {
		if( valor > this.getLimiteSaque() ) {
			throw new DomainException("Limite Indisponivel!");
		}
		if(this.getSaldo() <= valor ) {
			throw new DomainException("Saldo Indisponivel!");
		}
		this.saldo -= valor;
		System.out.println("Novo Saldo: " + this.getSaldo());
	}
}

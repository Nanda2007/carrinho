package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarrinhoComprasFactory {

    Map<String, CarrinhoCompras> carrinhosCompras = new HashMap<String, CarrinhoCompras>();
	
    public CarrinhoCompras criar(String identificacaoCliente) {
    	CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
    	
    	if(carrinhosCompras.containsKey(identificacaoCliente)) {
    		carrinhoCompras = null;
    	} else {
    		carrinhosCompras.put(identificacaoCliente, carrinhoCompras);
    	}
    	
    	return carrinhoCompras;
    }

    public BigDecimal getValorTicketMedio() {
    	List<CarrinhoCompras> carrinhoComprasL = new ArrayList<>(carrinhosCompras.values());
    	
    	carrinhoComprasL.stream()
    	                    .forEach(s -> s.getValorTotal().plus().divide(new BigDecimal(carrinhoComprasL.size())));
        BigDecimal valorTicketMedio = (BigDecimal) carrinhoComprasL;
        return valorTicketMedio.setScale(2, RoundingMode.HALF_EVEN);
   	}

    public boolean invalidar(String identificacaoCliente) {
    	try {
    		carrinhosCompras.remove(identificacaoCliente);
    		return true;
    	    }
    	    catch(RuntimeException e) {
    		 return false;
    	}
    }
}
 

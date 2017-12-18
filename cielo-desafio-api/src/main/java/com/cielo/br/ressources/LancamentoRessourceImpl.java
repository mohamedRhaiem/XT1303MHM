/**
 * @author mohamed
 * @creadted date 17 de dez de 2017 21:29:27
 */
package com.cielo.br.ressources;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cielo.br.utils.UtilsService;



@RestController
@RequestMapping(LancamentoRessourceImpl.LANCAMENTO_BASE_URI)
public class LancamentoRessourceImpl implements LancamentoRessource{
	
	protected static final String LANCAMENTO_BASE_URI="/serv/v1/lancamento";
	@Autowired
	private UtilsService utilsService;


	@RequestMapping(value="/list",method=RequestMethod.GET)
	public JSONArray getList() {
		  return this.getUtilsService().getMockLancamento();
	}

	public UtilsService getUtilsService() {
		return utilsService;
	}

	public void setUtilsService(UtilsService utilsService) {
		this.utilsService = utilsService;
	}

}

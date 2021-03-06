package br.com.mykidpet.util.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class CicloDeVidaListener implements PhaseListener{
	private static final long serialVersionUID = 1L;
	private Long tempoInicial;
	
	@Override
	public void afterPhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Depois da fase: " + event.getPhaseId());
		System.out.println("Tempo que demorou:" + (System.currentTimeMillis()-tempoInicial ));
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		tempoInicial = System.currentTimeMillis();
		System.out.println("Antes da fase: " + event.getPhaseId());		
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.ANY_PHASE;
	}

	
}

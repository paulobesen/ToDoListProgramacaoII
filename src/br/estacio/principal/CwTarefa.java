package br.estacio.principal;

import java.util.ArrayList;

public class CwTarefa {
    private int nCdTarefa;
    private String sDsTarefa;
    
    public CwTarefa(int nCdTarefa, String sDsTarefa) {
        this.nCdTarefa = nCdTarefa;
        this.sDsTarefa = sDsTarefa;
    }

    public CwTarefa() {
    }

    public int getnCdTarefa() {
        return nCdTarefa;
    }

    public void setnCdTarefa(int nCdTarefa) {
        this.nCdTarefa = nCdTarefa;
    }
    
    public void setnCdTarefa(ArrayList<CwTarefa> lstTarefas) {
        this.nCdTarefa = buscarCodigoParaNovaTarefa(lstTarefas);
    }

    public String getsDsTarefa() {
        return sDsTarefa;
    }

    public void setsDsTarefa(String sDsTarefa) {
        this.sDsTarefa = sDsTarefa;
    }
    
    public int buscarCodigoParaNovaTarefa(ArrayList<CwTarefa> lstTarefas){
        int nCdMax = 0;
        for (CwTarefa cwTarefa : lstTarefas) {
            if (cwTarefa.getnCdTarefa() > nCdMax){
                nCdMax = cwTarefa.getnCdTarefa();
            }
        }
        nCdMax++;
        return nCdMax;
    }
}

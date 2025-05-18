package model.entity;

import java.time.LocalDateTime;

public class Disponibilidade {
    private int id;
    private String cpfColetor;
    private LocalDateTime horario;
    private String estado;

    public Disponibilidade(int id, String cpfColetor, LocalDateTime horario, String estado) {
        setId(id);
    	setCpfColetor(cpfColetor);
        setHorario(horario);
        setEstado(estado);
    }


    public Disponibilidade(String cpfColetor, LocalDateTime horario, String estado) {
        setCpfColetor(cpfColetor);
        setHorario(horario);
        setEstado(estado);
    }

    public int getId() {
        return id;
    }

    public String getCpfColetor() {
        return cpfColetor;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCpfColetor(String cpfColetor) {
        this.cpfColetor = cpfColetor;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

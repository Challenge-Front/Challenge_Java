package org.example.assegurado;


public class Sintomas {
     private Long id;
     private Long id_veiculo;
     private String cpf;
     private Luzes luzesAcesas ;
     private String sintomasRelatados;
     private String diagnostico;


     public Sintomas(Long id, Long id_veiculo, Luzes luzesAcesas, String diagnostico, String sintomasRelatados) {
          this.id = id;
          this.id_veiculo = id_veiculo;
          this.cpf = cpf;
          this.luzesAcesas = luzesAcesas;
          this.diagnostico = diagnostico;
          this.sintomasRelatados = sintomasRelatados;
     }
     public Sintomas(Long id, Long id_veiculo, String cpf, String diagnostico, String sintomasRelatados) {
          this.id = id;
          this.id_veiculo = id_veiculo;
          this.cpf = cpf;
          this.diagnostico = diagnostico;
          this.sintomasRelatados = sintomasRelatados;
     }

     public void montaDiagnostico(Luzes luzesAcesas, String sintomasRelatados){
          //ToDo:Implementar método, retorno de string
     }

     public String getCpf() {
          return cpf;
     }

     public Long getId() {
          return id;
     }

     public Long getId_veiculo() {
          return id_veiculo;
     }

     public Luzes getLuzesAcesas() {
          return luzesAcesas;
     }

     public String getSintomasRelatados() {
          return sintomasRelatados;
     }

     public String getDiagnostico() {
          return diagnostico;
     }
}

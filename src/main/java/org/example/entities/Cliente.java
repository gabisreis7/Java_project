package org.example.entities;

public class Cliente {

        private Long id;
        private String nome;
        private int idade;
        private String email;
        private String senha;
        private long numeroCpf;
        private long numeroRg;
        private String endereco;
        private long numeroCnh;

        public Cliente() {

        }

    public Cliente(Long id, String nome, int idade, String email, String senha, long numeroCpf, long numeroRg, String endereco, long numeroCnh) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
        this.numeroCpf = numeroCpf;
        this.numeroRg = numeroRg;
        this.endereco = endereco;
        this.numeroCnh = numeroCnh;
    }

    public Cliente(String email, String endereco, Long id, int idade, String nome, long numeroCnh, long numeroCpf, long numeroRg, String senha) {
        this.email = email;
        this.endereco = endereco;
        this.id = id;
        this.idade = idade;
        this.nome = nome;
        this.numeroCnh = numeroCnh;
        this.numeroCpf = numeroCpf;
        this.numeroRg = numeroRg;
        this.senha = senha;
    }




    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade){

        this.idade = idade;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }

        public long getNumeroCpf() {
            return numeroCpf;
        }

        public void setNumeroCpf(long numeroCpf) {
            this.numeroCpf = numeroCpf;
        }

        public long getNumeroRg() {
            return numeroRg;
        }

        public void setNumeroRg(long numeroRg) {
            this.numeroRg = numeroRg;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public long getNumeroCnh() {
            return numeroCnh;
        }

        public void setNumeroCnh(long numeroCnh) {
            this.numeroCnh = numeroCnh;
        }


        public void mostrarRegistroDados() {
            System.out.println("Dados pessoais cadastrados!");
            System.out.println("");
            System.out.println("Nome: " + getNome());
            System.out.println("Número CPF: " + getNumeroCpf());
            System.out.println("Número RG: " + getNumeroRg());
            System.out.println("Número CNH: " + getNumeroCnh());
            System.out.println("Email: " + getEmail());
            System.out.println("Endereço completo: " + getEndereco());

        }
    }



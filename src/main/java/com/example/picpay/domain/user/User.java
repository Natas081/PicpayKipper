package com.example.picpay.domain.user;


//NAO PRECISA DE AUTENTICAÇÃO
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity(name="Users")//Define como entidade no banco
@Table(name="Users")//cria a tabela nobanco
@Getter
@Setter
@AllArgsConstructor//aplica todos os getters setters da classe
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User {
    @Id//primeiro atributo é id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String firstName;
    private String lastName;

    @Column(unique = true)//a coluna document é unica
    private String document;
    @Column(unique = true)
    private String email;

    private String password;
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}

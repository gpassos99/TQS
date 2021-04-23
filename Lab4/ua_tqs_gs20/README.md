a)
assertThat(found).extracting(Employee::getName).containsOnly("bob");
assertThat(response.getBody()).extracting(Employee::getName).containsExactly("bob", "alex");
assertThat(allEmployees).hasSize(3).extracting(Employee::getName).containsOnly(alex.getName(), ron.getName(), bob.getName());


b)
Na classe de testes EmployeeService_UnitTest, nos testes verifyFindByNameIsCalledOnce, verifyFindByIdIsCalledOnce e verifyFindAllEmployeesIsCalledOnce damos mock ao repositório sem envolver a base de dados.

c)
@Mock e @MockBean são ambos utilizadas para realizar testes à nossa aplicação. O @Mock usamos quando precisamos de fazer unit testing à nossa aplicação usando apenas jUnit e Mockito, enquanto que o @MockBean usamos quando trabalhamos
com spring boot e queremos substituir um bean por um mock.

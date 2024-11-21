# PowerHub - Gerenciamento de Aparelhos Residenciais

---

## PowerHub - Gerenciamento de Aparelhos Residenciais

O **PowerHub** é um software desenvolvido para facilitar o controle de dispositivos elétricos em residências. Ele permite que os usuários monitorem o consumo de energia de seus aparelhos, liguem e desliguem dispositivos remotamente, e gerem relatórios detalhados para análise e economia de energia.

---

## Principais Funcionalidades

### 1. Cadastro de Usuários
- Cadastro de novos usuários com informações como:
  - CPF (chave única de identificação).
  - Nome completo.
  - E-mail (único para cada usuário).
  - Número de telefone.
  - Senha (armazenada de forma segura).
- Validação de dados para garantir a integridade do sistema.

### 2. Gestão de Residências
- Cada usuário pode registrar múltiplas residências, com informações detalhadas:
  - Endereço completo: CEP, país, estado, cidade, bairro, rua, número e complemento.
  - Tarifa de energia elétrica específica da região (em R$/kWh).

### 3. Controle de Aparelhos
- Registro de aparelhos em cada residência, incluindo:
  - Nome do aparelho (ex.: Geladeira, Ar-condicionado).
  - Potência do aparelho (em watts).
  - Status atual (Ligado ou Desligado).
- Atualização do consumo acumulado para cada aparelho.

### 4. Monitoramento de Consumo
- Registro automático do consumo de energia dos aparelhos:
  - Tempo de uso do aparelho em cada período.
  - Cálculo do consumo em kWh.
  - Armazenamento de medições para análise histórica.

### 5. Relatórios Detalhados
- Geração de relatórios com informações como:
  - Consumo total de energia por residência.
  - Consumo detalhado por aparelho.
  - Período de análise configurável (ex.: diário, semanal, mensal).
  - Cálculo de custo total com base na tarifa de energia local.

### 6. Interface Amigável
- Interface gráfica intuitiva, permitindo que o usuário:
  - Gerencie facilmente residências e aparelhos.
  - Consulte relatórios em formato tabelar ou gráfico.
  - Visualize alertas de consumo excessivo.

---

## Tecnologias Utilizadas

### Backend
- **Java**:
  - Conexão ao banco de dados utilizando JDBC.
  - Manipulação de dados e lógica de negócios.
- **Spring Boot** *(futuro planejamento)* para APIs REST.

### Banco de Dados
- **MySQL**:
  - Estruturação relacional para armazenar usuários, residências, aparelhos, medições e relatórios.
  - Scripts SQL otimizados para consultas rápidas.

### Frontend
- **Java Swing**:
  - Interface gráfica desktop.
  - Componentes interativos para cadastro e gerenciamento.

### Segurança
- Senhas armazenadas com hash seguro (ex.: bcrypt ou SHA-256).
- Validação de entradas para evitar SQL Injection.

---

## Como Executar o Projeto

### Pré-requisitos
1. **Java Development Kit (JDK)**: Versão 11 ou superior.
2. **MySQL Server**:
   - Banco de dados configurado e rodando.
   - Credenciais com permissões adequadas.
3. **MySQL Connector/J**:
   - Incluído no classpath do projeto.

### Passos para executar
1. Abra o **MySQL Developer** ou qualquer ferramenta de gerenciamento de banco de dados.
2. Copie e cole o script SQL fornecido no repositório para criar o banco de dados e as tabelas.
3. Baixe o código do projeto.
4. Abra o projeto na sua IDE favorita (ex.: IntelliJ, Eclipse ou NetBeans).
5. Compile e execute o projeto diretamente pela IDE.

---

## Futuras Funcionalidades
- Suporte a controle remoto via APIs REST.
- Aplicativo móvel para integração com o sistema desktop.
- Notificações automáticas sobre consumo excessivo.
- Integração com dispositivos IoT para controle em tempo real.

---

**Desenvolvido com dedicação para promover a sustentabilidade e o uso consciente de energia.**

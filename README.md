# <strong>Desafio de Desenvolvimento JAVA – TODO List </strong>

<p>Você foi contratado para desenvolver uma <strong>API de gerenciamento de tarefas (TODO List)</strong> em <strong>Java</strong>, utilizando  
  <strong>Spring Boot</strong> e  <strong>PostgreSQL</strong> como banco de dados. </p>
<p>O sistema deve permitir que o usuário crie, atualize, consulte e remova tarefas, além de marcar ou desmarcar tarefas como concluídas.</p>

<br/>

## <strong>Requisitos da aplicação </strong>

<p>Cada tarefa deve possuir os seguintes atributos:</p>
<ul>
  <li>title (String, obrigatório) → Título da tarefa.</li>
  <li>description (String, opcional) → Detalhes adicionais sobre a tarefa. </li>
  <li>check (Boolean, default: false) → Indica se a tarefa foi concluída ou não. </li>
  <li>createdAt (LocalDateTime) → Data/hora de criação da tarefa. </li>
  <li>updatedAt (LocalDateTime) → Data/hora da última atualização.</li>
</ul>

<br/>

## <strong>Endpoints obrigatórios </strong>

<ul>
  <li><strong>GET</strong> /tasks </li>
  <ul>
    <li>Retorna todas as tarefas. </li/>
    <li>Aceita query param check=true ou check=false para filtrar apenas tarefas concluídas ou não concluídas. </li>
  </ul>
  <li><strong>POST</strong> /tasks</li>
  <ul>
    <li>Cadastra uma nova tarefa.</li>
  </ul>
  <li><strong>PUT</strong> /tasks/{id}</li>
  <ul>
    <li>Atualiza o name e/ou description de uma tarefa existente. </li>
  </ul>
  <li><strong>PATCH</strong> /tasks/{id}/check</li>
  <ul>
    <li>Alterna o status da tarefa entre concluída e não concluída. </li>
  </ul>
  <li><strong>DELETE</strong> /tasks/{id}</li>
   <ul>
    <li>Remove uma tarefa existente. </li>
  </ul>
</ul>

<br/>

## <strong>Critérios de avaliação </strong>

<ol>
  <li>Organização do código e boas práticas (pacotes, camadas, nomenclaturas). </li>
  <li>Uso correto do <strong>Spring Boot</strong> para criar os endpoints. </li>
  <li>Persistência de dados com <strong>PostgreSQL</strong>. </li>
  <li>Implementação correta das regras de negócio (ex.: createdAt automático, updatedAt ao atualizar, toggle do check). </li>
  <li>Clareza e legibilidade do código.</li>
</ol>




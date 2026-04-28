## ARQUITETURA DO SISTEMA

src/main/java/com/industrial/telemetrycollector/<br/>
│<br/>
├── config/                 # Configurações de Beans (InfluxDB, Postgres, Swagger)<br/>
│   ├── InfluxDBConfig.java<br/>
│   └── DatabaseConfig.java<br/>
│<br/>
├── controller/             # Endpoints da API (Recebe os dados das máquinas)<br/>
│   └── TelemetryController.java<br/>
│<br/>
├── service/                # Lógica de Negócio e Roteamento de Dados<br/>
│   ├── TelemetryService.java      # Orquestra para onde o dado vai<br/>
│   └── ValidationService.java     # Valida se os dados da máquina são íntegros<br/>
│<br/>
├── repository/             # Interfaces de Persistência<br/>
│   ├── relacional/         # Repositórios JPA (PostgreSQL)<br/>
│   │   └── MachineRepository.java<br/>
│   └── timeseries/         # DAO ou Componentes para InfluxDB<br/>
│       └── InfluxRepository.java<br/>
│<br/>
├── model/                  # Entidades e Objetos de Valor<br/>
│   ├── entity/             # Tabelas do PostgreSQL (Cadastro de máquinas)<br/>
│   │   └── Machine.java<br/>
│   └── dto/                # Objetos de transferência (JSON de entrada)<br/>
│       └── TelemetryDTO.java<br/>
│<br/>
├── exception/              # Tratamento de erros personalizado<br/>
│   └── GlobalExceptionHandler.java<br/>
│<br/>
└── TelemetryCollectorApplication.java # Classe Principal<br/>
## Architecture Highlights
┌─────────────────────────────────────────┐
│           Application.kt                  │
│  (Entry point, installs plugins)          │
└─────────────────────────────────────────┘
│
┌──────────────┼──────────────┐
▼              ▼              ▼
┌─────────┐  ┌──────────┐  ┌──────────┐
│   DI    │  │   JSON   │  │  Routing │
│ (Koin)  │  │ (Kotlinx)│  │ (Ktor)   │
└────┬────┘  └──────────┘  └────┬─────┘
│                           │
│    ┌──────────────────────┘
│    │
▼    ▼
┌─────────────────────────────────────────┐
│         Routing.kt                      │
│  Injects ProductService                 │
│  Delegates to ProductRoutes             │
└─────────────────────────────────────────┘
│
▼
┌─────────────────────────────────────────┐
│        ProductRoutes.kt                 │
│  Receives ProductService as parameter   │
│  Defines HTTP endpoints                 │
└─────────────────────────────────────────┘
│
▼
┌─────────────────────────────────────────┐
│       ProductService.kt                 │
│  Business logic, mock data              │
└─────────────────────────────────────────┘


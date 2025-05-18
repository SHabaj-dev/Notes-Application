# Notes Application

A modern Android application for managing notes with Material Design 3, MVVM architecture, and Kotlin Coroutines.

## Features

- Create, read, update, and delete notes
- Material Design 3 UI components
- Dark/Light theme support
- Search functionality
- Image attachment support
- Checklist support
- Modern architecture with MVVM
- Dependency Injection with Hilt
- Kotlin Coroutines for asynchronous operations
- Room Database for local storage
- Navigation Component for screen navigation

## Tech Stack

- Kotlin
- Android Jetpack
  - ViewModel
  - LiveData
  - Room Database
  - Navigation Component
  - DataStore Preferences
- Material Design 3
- Hilt for Dependency Injection
- Kotlin Coroutines
- Flow
- ViewBinding

## Project Structure

```
app/
├── data/
│   ├── local/
│   │   ├── dao/
│   │   ├── entity/
│   │   └── AppDatabase.kt
│   ├── repository/
│   │   └── NoteRepository.kt
│   └── model/
│       └── Note.kt
├── di/
│   └── AppModule.kt
├── ui/
│   ├── home/
│   │   ├── HomeFragment.kt
│   │   ├── HomeViewModel.kt
│   │   └── NotesAdapter.kt
│   ├── edit/
│   │   ├── EditNoteFragment.kt
│   │   └── EditNoteViewModel.kt
│   └── settings/
│       ├── SettingsFragment.kt
│       └── SettingsViewModel.kt
└── MainActivity.kt
```

## Setup Instructions

1. Clone the repository:
```bash
git clone https://github.com/SHabaj-dev/Notes-Application.git
```

2. Open the project in Android Studio

3. Build and run the application

## Development Workflow

### Git Flow

1. Main branches:
   - `main`: Production-ready code
   - `develop`: Development branch

2. Supporting branches:
   - `feature/*`: New features
   - `bugfix/*`: Bug fixes
   - `release/*`: Release preparation
   - `hotfix/*`: Production fixes

### Branch Naming Convention

- Feature branches: `feature/description`
- Bug fix branches: `bugfix/description`
- Release branches: `release/version`
- Hotfix branches: `hotfix/description`

### Commit Message Convention

```
<type>(<scope>): <description>

[optional body]

[optional footer]
```

Types:
- feat: New feature
- fix: Bug fix
- docs: Documentation
- style: Formatting
- refactor: Code restructuring
- test: Testing
- chore: Maintenance

### Pull Request Process

1. Create a feature/bugfix branch
2. Make your changes
3. Write tests if applicable
4. Update documentation
5. Create a pull request to develop
6. Get code review
7. Merge after approval

## CI/CD Pipeline

The project uses GitHub Actions for continuous integration and deployment:

### Workflows

1. Build and Test
   - Triggers on pull requests and pushes to main/develop
   - Builds the project
   - Runs unit tests
   - Runs lint checks

2. Release
   - Triggers on tags
   - Builds release APK
   - Creates GitHub release
   - Uploads APK to release

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Material Design 3
- Android Jetpack
- Kotlin Coroutines
- Hilt
- Room Database 
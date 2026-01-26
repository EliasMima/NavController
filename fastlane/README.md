fastlane documentation
----

# Installation

Make sure you have the latest version of the Xcode command line tools installed:

```sh
xcode-select --install
```

For _fastlane_ installation instructions, see [Installing _fastlane_](https://docs.fastlane.tools/#installing-fastlane)

# Available Actions

## Android

### android verify

```sh
[bundle exec] fastlane android verify
```

Run unit tests, lint checks, and code quality analysis

### android sonarqube

```sh
[bundle exec] fastlane android sonarqube
```

Run SonarQube code quality scan

### android build_dev

```sh
[bundle exec] fastlane android build_dev
```

Build Dev APK

### android distribute_apk

```sh
[bundle exec] fastlane android distribute_apk
```

Build and distribute APK to Firebase

### android distribute_with_notes

```sh
[bundle exec] fastlane android distribute_with_notes
```

Build and distribute with dynamic release notes

### android full_pipeline

```sh
[bundle exec] fastlane android full_pipeline
```

Run complete pipeline: verify → build → deploy

----

This README.md is auto-generated and will be re-generated every time [_fastlane_](https://fastlane.tools) is run.

More information about _fastlane_ can be found on [fastlane.tools](https://fastlane.tools).

The documentation of _fastlane_ can be found on [docs.fastlane.tools](https://docs.fastlane.tools).

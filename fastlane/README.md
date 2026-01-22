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

### android deploy_dev

```sh
[bundle exec] fastlane android deploy_dev
```

Deploy Dev build to Firebase App Distribution

### android full_pipeline

```sh
[bundle exec] fastlane android full_pipeline
```

Run complete pipeline: verify → build → deploy

----

This README.md is auto-generated and will be re-generated every time [_fastlane_](https://fastlane.tools) is run.

More information about _fastlane_ can be found on [fastlane.tools](https://fastlane.tools).

The documentation of _fastlane_ can be found on [docs.fastlane.tools](https://docs.fastlane.tools).

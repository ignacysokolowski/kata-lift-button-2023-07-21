import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jmailen.gradle.kotlinter.tasks.LintTask

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlinter)
}

repositories {
    mavenCentral()
}

group = "ignacysokolowski"

kotlin {
    sourceSets.all {
        languageSettings {
            languageVersion = "2.0"
        }
    }
}

testing {
    suites {
        @Suppress("UnstableApiUsage")
        withType(JvmTestSuite::class).configureEach {
            useJUnitJupiter()

            dependencies {
                implementation(rootProject.libs.junit.jupiter.api)
                implementation(rootProject.libs.hamkrest)
                runtimeOnly(rootProject.libs.junit.jupiter.engine)
            }

            targets {
                all {
                    testTask.configure {
                        testLogging {
                            showExceptions = true
                            exceptionFormat = TestExceptionFormat.FULL
                            events("passed", "skipped", "failed")

                            addTestListener(object : TestListener {
                                override fun beforeSuite(suite: TestDescriptor) = Unit
                                override fun beforeTest(testDescriptor: TestDescriptor) = Unit
                                override fun afterTest(testDescriptor: TestDescriptor, result: TestResult) = Unit
                                override fun afterSuite(suite: TestDescriptor, result: TestResult) {
                                    if (suite.parent == null) {
                                        println(
                                            "\n${result.resultType}: ${result.testCount} tests, " +
                                                "${result.successfulTestCount} passed, " +
                                                "${result.failedTestCount} failed, " +
                                                "${result.skippedTestCount} skipped " +
                                                "in ${(result.endTime - result.startTime).toFloat() / 1000}s"
                                        )
                                    }
                                }
                            })
                        }
                    }
                }
            }
        }
    }
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
          jvmTarget = "17"
        }
    }

    withType<LintTask> {
        shouldRunAfter("test")
    }

    withType<Jar> {
        shouldRunAfter("test", "lintKotlin")
    }
}

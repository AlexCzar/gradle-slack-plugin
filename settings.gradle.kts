pluginManagement {
	repositories {
		gradlePluginPortal()
		maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
	}

	resolutionStrategy {
		eachPlugin {
			if (requested.id.id.startsWith("org.jetbrains.kotlin")) {
				useVersion(gradle.rootProject.extra["kotlin.version"] as String)
			}
		}
	}
}

rootProject.name = "gradle-slack-plugin"


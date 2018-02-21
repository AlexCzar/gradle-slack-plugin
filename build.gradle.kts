import org.gradle.api.tasks.wrapper.Wrapper
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


group = "io.czar"
version = "0.0.1"

plugins {
	`kotlin-dsl`
	kotlin("jvm")
}

task<Wrapper>("wrapper") {
	gradleVersion = "4.4.1"
	distributionType = Wrapper.DistributionType.ALL
}

repositories {
	maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
	jcenter()
}

dependencies {
	compile(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
	kotlinOptions.jvmTarget = "1.8"
}
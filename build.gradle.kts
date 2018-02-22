import org.gradle.api.tasks.wrapper.Wrapper
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	`kotlin-dsl`
	kotlin("jvm")
	`java-gradle-plugin`
}

group = "io.czar"
version = "0.0.1"

task<Wrapper>("wrapper") {
	gradleVersion = "4.5.1"
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
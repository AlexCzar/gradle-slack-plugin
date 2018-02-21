package io.czar.gradle.slack

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionListener
import org.gradle.api.tasks.TaskState

private lateinit var configuration: SlackExtension

class SlackPlugin : Plugin<Project> {
	override fun apply(project: Project) {
		project.extensions.create("slack", SlackExtension::class.java)
	}
}

class SlackExtension(
	val webHook: String,
	val messageTemplate: String,
	val monitorTasks: List<Task>
)

private val meow = StringBuilder()

object TaskExecutionListener : TaskExecutionListener {
	override fun beforeExecute(task: Task) {
		task.logging.addStandardOutputListener { meow.append(it) }
		TODO("not implemented")
	}

	override fun afterExecute(task: Task, state: TaskState) {
		handleTaskFinished(task, state)
		TODO("not implemented")
	}
}

fun handleTaskFinished(task: Task, state: TaskState) {
	val failure = state.failure
	val shouldNotify = failure != null || task.isMonitored

	if (shouldNotify) {
		TODO("Notify")
	}
}

val Task.isMonitored: Boolean
	get() = this in configuration.monitorTasks

fun monitor(project: Project) {
	project.gradle.taskGraph.addTaskExecutionListener(TaskExecutionListener)
}
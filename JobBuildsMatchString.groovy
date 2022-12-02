JOB_NAME = "My Job"
BUILD_STRING = "Hello, world"

def job = Jenkins.instance.items.find { it.name == JOB_NAME }
for (build in job.builds) {
  def log = build.log
  if (log.contains(BUILD_STRING)) {
    println "${job.name}: ${build.id}"
  }
}

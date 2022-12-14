###########################################################
# Script executes code on agent from Master Script Console
###########################################################


import hudson.util.RemotingDiagnostics
import jenkins.model.Jenkins

String agentName = 'your agent name'
//groovy script you want executed on an agent
groovy_script = '''
println System.getenv("PATH")
println "uname -a".execute().text
'''.trim()

String result
Jenkins.instance.slaves.find { agent ->
    agent.name == agentName
}.with { agent ->
    result = RemotingDiagnostics.executeGroovy(groovy_script, agent.channel)
}
println result

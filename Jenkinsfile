new gantry.PxBuild()
  .withName('carter')
  .withDockerRegistry('registry-v2.revinate.net/app')
  .inferVersionFromJar()
  .withFunctionalTests()
  .withAutoDeployToTest()
  .withPostDeployTests('dint')
  .notifySlackChannel('#integrations-r')
  .execute()

stage 'Helm publish'
node {
    checkout scm
    helmPublish()
}

job('AdventureTime.Build') {
    description 'Build and test the app.'
    scm {
        git{
            remote {
               github 'NicolaiOksen/Adventure-Time'
               branch 'origin/ready/**'
               credentials("2f0ddb6f-f67f-4c0b-9a17-09455139185c")
            }
            extensions {
                wipeOutWorkspace()
                pruneBranches()
            }
        }
        
    }
    wrappers {
        pretestedIntegration("SQUASHED", "master", "origin")
    }
    publishers {
        pretestedIntegration()
    }
    triggers {
        useGitHubHooks()
    }
    steps {
        shell('./test.sh')
    }
}
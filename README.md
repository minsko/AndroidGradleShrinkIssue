# AndroidGradleShrinkIssue
Demonstration for issues with the Android Gradle shrinkResources in 1.5.0 plugin
Raw resources are corrupted instead of being removed.

This sample has four raw resources.  One is directly referenced and three are referenced indirectly (so shrinkResources will think they are not used.

In 1.3.1, the three indirectly referenced resources are properly removed.

In 1.5.0 (and 2.0.0-alpha3) those three are left but they are corrupted.

There are screenshots showing the different scenarios.

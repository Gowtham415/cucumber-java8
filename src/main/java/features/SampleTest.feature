@FeatureSetup
Feature: First Feature
Scenario: Google search
  Given the user opens the google page
  When user searches for "Selenium"
  Then search Results should be displayed
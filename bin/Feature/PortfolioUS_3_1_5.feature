@PortfolioUS_3_1_5
Feature: Creating a new portfolio  with reference
		Description :As an Approver in order to fulfil the need
					 for a creation of a portfolio, 
					 I want to create a new portfolio

Background:
			Given that portfolio user has raised a request to create a new individual portfolio

Scenario: Approver wishes to create a new portfolio

When the Approver has approved the request for a new portfolio
Then the Approver will take inputs related to Concept, Plan, Prototype, Dev & Test, Launch, Lifecycle Mgmt, domain, technology, skills etc
And Approver creates a new portfolio

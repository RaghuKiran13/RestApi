@PortfolioUS_3_2_1
Feature: Requesting for a new Portfolio without reference 
		Description: As a Portfolio user in order to change 
					 the existing portfolio without reference,
					 I want to raise request to Approver

Background:
			Given  Given that project is already created  there is a need to create a new portfolio without reference 

Scenario:  Portfolio user raise request for new portfolio without reference

When portfolio user wants few fields to be changed in existing portfolio without reference 
Then portfolio user will raise a request for a new  portfolio without reference to Approver
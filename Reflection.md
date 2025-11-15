# Reflection

During the design phase of this Chomp Game project, I spent most of my time understanding the original architecture and 
deciding how closely I should follow it. The original design provided a clear separation between model, view, and controller
using a variation of the MVC pattern, and it also incorporated an abstract Game class that follows the Template Method idea. 
When I translated the design into my own implementation, I tried to stay faithful to the original structure, especially 
in how Board, Cell, Player, and CHOMPGame interact. However, while working through the flow of GUI events, I discovered 
that placing all GUI wiring directly inside the controller created unnecessary coupling and made the controller harder 
to maintain. As a result, one of my intentional deviations from the original design was introducing a Display façade to 
encapsulate the construction and refreshing of GUI components. This change helped maintain cleaner layers between the 
logic (CHOMPGame) and the view (Swing panels), but at the same time preserved the spirit of the original design.

The implementation phase helped me better understand the practical challenges of Swing event-driven programming. Mapping 
the conceptual model to interactive GUI components required decisions that are not always obvious from a high-level design. 
For example, connecting each button to a single ActionListener and using action commands to pass coordinates turned out 
to be both elegant and simple, but it took several iterations to get right. I also had to carefully think through when 
the game state should be updated, when repaint() and revalidate() should occur, and how to visually represent eaten cells 
and the poison cell. The final implementation works as intended and follows the rules of Chomp, but the process highlighted 
the importance of testing small pieces early and adjusting the design where implementation details expose weaknesses. 
Overall, this project gave me a clearer appreciation for why clean separation of concerns matters, and how real-world 
constraints often require small but meaningful adaptations to an initial design.
